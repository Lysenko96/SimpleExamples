function checkProtectedRows() {
  const ss = SpreadsheetApp.getActiveSpreadsheet();
  const source = ss.getSheetByName("01_Доступи");
  const archive = ss.getSheetByName("02_Архів");

  if (!source || !archive) {
    throw new Error("Не знайдено 01_Доступи або 02_Архів");
  }

  const protections = source.getProtections(
    SpreadsheetApp.ProtectionType.RANGE
  );

  // Сначала собираем номера защищённых строк
  const protectedRows = new Set();

  protections.forEach(protection => {
    if (!protection.isWarningOnly()) {
      const range = protection.getRange();

      const startRow = range.getRow();
      const endRow = startRow + range.getNumRows() - 1;

      for (let row = startRow; row <= endRow; row++) {
        protectedRows.add(row);
      }
    }
  });

  // Обрабатываем снизу вверх, чтобы номера строк не смещались
  const rows = [...protectedRows].sort((a, b) => b - a);
  console.log(rows);

  rows.forEach(row => {
    if (row < 1) return;

    const lastColumn = source.getLastColumn();

    // Получаем данные строки
    const data = source
      .getRange(row, 1, 1, lastColumn)
      .getValues();
    
const lastArchiveRow = archive.getLastRow();

let isDifferent = true;

if (lastArchiveRow > 1) {
  const previousData = archive
    .getRange(lastArchiveRow, 1, 1, lastColumn)
    .getValues();

  isDifferent =
    JSON.stringify(previousData) !== JSON.stringify(data);
}

if (isDifferent) {
  archive
    .getRange(
      lastArchiveRow + 1,
      1,
      1,
      lastColumn
    )
    .setValues(data);
}
  });
}
