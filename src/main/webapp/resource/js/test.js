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

	$("#addtest").click(function() {
		var url = "testcontroller/addtest";
		$.ajax({
			type : 'post',
			url : url,
			data : {
				id : $("#addtestid").val(),
				name : $("#addtestname").val()
			},
			dataType : 'json',
			success : addSuccess,
			error : onerror
		});
	});

	$("#deletetest").click(function() {
		var url = "testcontroller/deltestbyid";
		$.ajax({
			type : 'get',
			url : url,
			data : {
				id : $( '#testdiv input[type=checkbox][name=cbDetail]:checked') .val()
			},
			dataType : 'json',
			success : deleteSuccess,
			error : onerror
		});
	});

	$("#updatetest").click(function() {
		var data = $( '#testdiv input[type=checkbox][name=cbDetail]:checked') .val();
		alert(data);
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
		html += '<tr><td><input id="cbDetail" name="cbDetail" type="checkbox" value="'
				+ testDataInfo.id
				+ '"/></td><td>'
				+ testDataInfo.id
				+ '</td><td>' + testDataInfo.name + '</td></tr>';
	}
	$("#testdiv").html(html);
}

function addSuccess(data) {

	var testid = data;
	var url = "testcontroller/gettest";
	$.ajax({
		type : 'get',
		url : url,
		data : {
			id : testid
		},
		dataType : 'json',
		success : searchSuccess,
		error : onerror
	});
}

function deleteSuccess(data) {
	var url = "testcontroller/gettest";
	$.ajax({
		type : 'get',
		url : url,
		data : {
			id : ""
		},
		dataType : 'json',
		success : searchSuccess,
		error : onerror
	});
}
