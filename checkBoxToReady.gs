function onEdit(e) {
  if (!e || !e.range) return;

  const sheet = e.range.getSheet();
  const row = e.range.getRow();
  const column = e.range.getColumn();

  if (column < 2 || column > 26 || row < 8 || row > 10) return;


  const checkboxes = sheet.getRange(8,column,3,1).getValues().flat();

  const allPassed = checkboxes.every(box => box === true);

  if (allPassed) {
    sheet.getRange(11,column,1,1).setValue("Готово");

  }
}
