$(function() {

	$("#gettest").click(function() {
		var url = "testcontroller/gettest";
		$.ajax({
			type : 'get',
			url : url,
			data : {
				id : $("#testid").val()
			},
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

	var testData = data;

	if (testData.length == 1 && testData[0] == null) {
		alert("查无此户！！！");
	}

	if (testData.errorType == "error") {
		onerror(data);
		return;
	}

	var html = '<tr><td><input id="cbHead" type="checkbox"/></td><td>ID</td><td>Name</td></tr>';
	for (var i = 0; i < testData.length; i++) {
		var testDataInfo = testData[i];
		html += '<tr><td><input id="cbDetail" type="checkbox" value='+ testDataInfo.id +'/></td><td>'
				+ testDataInfo.id + '</td><td>' + testDataInfo.name
				+ '</td></tr>';
	}
	$("#testdiv").html(html);
}
