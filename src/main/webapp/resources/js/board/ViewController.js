/**
 * 
 */


// 댓글 목록을 가져오기위한 필요 데이터

let commentList = document.getElementById("comment-list");
const url = location.href;
const pattern = /id=(\d+)/g;

let DATA = {
	"id": pattern.exec(url)[1],
	"page": 1
}
console.log( DATA );

getComments( DATA );
// 댓글 목록 가져오기
function getComments( DATA ){
	if( typeof $ == "function" ){
		$.ajax(
			{
				url: "http://localhost:8080/board2/board/ajax/comments",
				type: "GET",
				data: DATA,
				error: function( error ) {
					console.log("[error]",error);
				},
				success: function( result ) {
					console.log("[result]", result);
					
					if( result.comments != null ){
						commentList.append( createCommentElement(result.comments) );
					}
				},
				complete: function( com ) {
					console.log("[complete]", com);
				}
			}
		);
	}
}
// 댓글리스트 element 만들기
function createCommentElement( comments ){
	let elements = document.createElement("div");
	elements.setAttribute("class", "comment-container row");

	for(let i = 0; i < comments.length; i++){
		let container = document.createElement("div");
		container.setAttribute("class", "comment-item " + (i + 1));
		
		let row1 = document.createElement("div");
		let row2 = document.createElement("div");
		row1.setAttribute("class", "row comment-info");
		row2.setAttribute("class", "row comment-text");
		
		let r1c1 = document.createElement("div");
		let r1c2 = document.createElement("div");
		let r1c3 = document.createElement("div");
		
		let r2c1 = document.createElement("div");

		r1c1.setAttribute("class","col s4");
		r1c2.setAttribute("class","col s4");
		r1c3.setAttribute("class","col s4");
		
		r2c1.setAttribute("class","col s12");
		
		let no = document.createElement("a");
		let writer = document.createElement("a");
		let date = document.createElement("a");
		let comment = document.createElement("textarea");
		
		no.innerText = comments[i]["no"];
		writer.innerText = comments[i]["writer"];
		date.innerText = comments[i]["date"];
		comment.innerText = comments[i]["comment"];
		comment.setAttribute("class", "materialize-textarea");

		r1c1.append(no);
		r1c2.append(writer);
		r1c3.append(date);
		
		row1.append(r1c1);
		row1.append(r1c2);
		row1.append(r1c3);
		
		r2c1.append(comment);
		row2.append(r2c1);
		
		container.append(row1);
		container.append(row2);
	
		elements.append(container);
	}
	
	return elements;
}




// 댓글 작성하기 && after: 다시 목록불러오기

function getWritedComment(){
	// get DATA
	const commentWrite = document.getElementById("comment-write");
	
	let writer = commentWrite.getElementsByClassName("comment-input writer")[0];
	let password = commentWrite.getElementsByClassName("comment-input password")[0];
	let date = commentWrite.getElementsByClassName("comment-input date")[0];
	let comment = commentWrite.getElementsByClassName("comment-input comment")[0];
	
	let data = {
		"writer": writer.value,
		"password": password.value,
		"date": date.value,
		"comment": comment.value,
		"boardNo": DATA["id"] // 이걸 어디서 주고 받아올까
	}
	
	writer.value = "";
	password.value = "";
	comment.value = "";
	
	return data;
}

function saveComment(){
	const data = getWritedComment();
	$.ajax({
		contentType:"application/json",
		url: "http://localhost:8080/board2/board/ajax/comment/insert",
		type: "post",
		dataType: "json",
		data: JSON.stringify( data ),
		
		error: function(error){
			console.log("[ajax-error]", error);
		},
		success: function(result){
			console.log("[ajax-success]", result);
			
		},
		complete: function(){
			
			// 다시 호출하기
			console.log("[리스트 다시 불러오기]");
			if( commentList.childElementCount > 0 ){
				commentList.children[0].remove(); // null이 아닐 때 삭제
			}
			getComments(DATA);
		}
	});
}























