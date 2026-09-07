function onEdit(e) {
  if (!e || !e.range) return;

  const sheet = e.range.getSheet();
  const row = e.range.getRow();
  const column = e.range.getColumn();

  if (column < 8 || column > 10) return;

  const checkboxes = sheet.getRange(row,8,1,3).getValues().flat();

  const allPassed = checkboxes.every(box => box === true);

  if (allPassed) {
    sheet.getRange(row,11,1,1).setValue("Готово");
  }
}
