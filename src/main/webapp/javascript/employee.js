// <tr><td>id</td></tr><tr><td> first</td></tr><tr><td> last </td></tr>
// 필드의 갯수만큼 반복 for in 반복문 사용
function generate_table() {
    let 
    // let tbl = document.createElement("table");
    // let tblBody = document.createElement("tbody");
    // for (var i = 0; i < 2; i++) {
    //     // 테이블 행 생성
    //     var row = document.createElement("tr");

    //     for (let j = 0; j < 2; j++) {

    //         let cell = document.createElement("td");
    //         let cellText = document.createTextNode("cell in row " + i + ", column " + j);
    //         cell.appendChild(cellText);
    //         row.appendChild(cell);

    //         tbl.appendChild(tblBody);
    //     }

    //     body.appendChild(tbl);
    //     tbl.appendChild(tblBody);

    //     body.appendChild(tbl);


}



function makeRow(obj) {
    let tr = document.createElement('tr');
    // tr.addEventListener('mouseover',mover, capturing);
    for (let field in obj) {

        console.log(`필드 ${field}, 값: ${obj[field]}`);
        let td = document.createElement('td');
        td.appendChild(text);
        tr.appendChild(td);
    }
}


// let btn = document.createElement('input');
// btn.addEventListener('click', deleteRow);
// tr.addEventListner('click', mover, true)
// tr.addEventListner('click', mout, true)
// tr.addEventListner('click', trClick, true) // 상위요소 => 하위요소
// let trClick = function (arg) {
// window.alert(this.children)
// }

// // deleteRow();
// ars.stopPropation(); // 이벤트의 전파를 차단
//
//arrow function 일 경우에는 this 키워드는 window 오브젝트
// arg.target.parentElement.parentElement. remove();

// let mover =  function (arg) {
//  arg.stopProagation();
//     arg.style.backgroundColor = 'yellow';
// }
//  let mout = function (arg) {
// function 일 경우에는 this 키워드는 event 대상 
// this.style.backgroundColor = '';





//삭제 버튼