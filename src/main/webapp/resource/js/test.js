$(function() {

	$("#test").click(function() {
		var url = "testcontroller/test";
		$.ajax({
			type : 'get',
			url : url,
			data : {},
			dataType : 'json',
			success : searchSuccess,
			error : onerror
		});
	});
});

// 处理失败
function onerror(data) {
	alert("请求失败");
}

// 请求成功
function searchSuccess(data) {

	if (data.errorType == "error") {
		onerror(data);
		return;
	}

	var testData = data;
	var html = "<tr><td>ID</td><td>Name</td></tr>";
	for (var i = 0; i < testData.length; i++) {
		var testDataInfo = testData[i];
		html += "<tr><td>" + testDataInfo.id + "</td><td>" + testDataInfo.name
				+ "</td></tr>";
	}
	$("#testdiv").html(html);
}
