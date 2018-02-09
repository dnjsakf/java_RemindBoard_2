/**
 * Variable
 */
const ctxPath = "http://localhost:8080/board2/board/list?page=";

/**
 * Variable For Pagination
 */
let nowPage = 1;

/**
 * Next, Previous Button Event
 */
// 다음 페이지로
function nextPage( page, nextPages ){
	if( page <= nextPages ){
		nowPage = page;	// 현재 페이지 수정
		location.href = ctxPath + page;
	}
}
// 이전 페이지로
function prevPage( page, prevPages ){
	if( prevPages > 0 && page >= prevPages){
		nowPage = page;	// 현재 페이지 수정
		location.href = ctxPath + page;
	}
}

/**
 * Pagination Event
 */
const movePages = document.getElementsByClassName("move-page-btn");
for(let i = 0 ; i < movePages.length; i++){
	movePages[i].addEventListener("click", function( event ){
		console.log("[clicked]");
		let page = event.target.getAttribute("page");
		nowPage = page;	// 현재 페이지 수정, 이거 이렇게 나눠서 저장할 필요가 있을까? 불필요한 대입같은데
		if( page > 0 ){
			location.href = ctxPath + page;
		}
	});
}

/*
 * To View Page Event
 */
const contents = document.getElementsByClassName("content-container");
for(let i = 0; i < contents.length; i++){
	contents[i].addEventListener("click" , function( event ){
		console.log( "clicked" );
		location.href = makeViewURL({
			"page": nowPage,
			"id": event.target.parentElement.getAttribute("content-id") 
		});
	});
}


/**
 * Service For View
 */
function makeViewURL( conditions ){
	let url = "http://localhost:8080/board2/board/view?";
	let count = 0;
	for(let attr in conditions ){
		if( count > 0 ){ url += "&"; }
		url += (  attr + "=" + conditions[attr] );
		count += 1;
	}
	return url;
}

