function closeModal() {
	$('#boardModal').hide();
};

function updateModal(boardCd, boardNm) {
	$('#boardNmModal').val(boardNm);
	$('#boardCdModal').val(boardCd);
	$('#boardModal').show();
};