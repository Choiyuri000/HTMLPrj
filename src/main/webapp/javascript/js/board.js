function submitFnc(e) {
    // trTag.setAttribute('class', 'altRow');
    e.preventDefault();
    let num = document.frmB.num.value;
    let title = document.frmB.title.value;
    let writer = document.frmB.writer.value;
    let regDate = document.frmB.regDate.value;

    let liTag = document.createElement('li');
    liTag.setAttribute('class', 'altRow');

    if (document.frmB.num.value == '') {
        alert('번호 입력');
        document.frmB.num.focus();
        return;
    }
    if (document.frmB.title.value == '') {
        alert('제목 입력');
        document.frmB.title.focus();
        return;
    }
    if (document.frmB.writer.value == '') {
        alert('작성자 입력');
        document.frmB.writer.focus();
        return;
    }
    if (document.frmB.regDate.value == '') {
        alert('날짜 입력');
        document.frmB.regDate.focus();
        return;
    }


    let childCnt = list.children.length + 1;
    if (childCnt % 2 == 0) {
        let liTag = createTr(num, title, writer, regDate);
        liTag.setAttribute('class', 'altRow');
        list.appendChild(liTag);
    } else {
        list.appendChild(createTr(num, title, writer, regDate));
    }

    return liTag;
}

// 사용자 입력한 값을 활용해서 tr 완성
function createTr(num, title, writer, regDate) {
    let trTag = document.createElement('tr');
    trTag.setAttribute('id', num);
    for (let i = 0; i < arguments.length; i++) {
        let tdTag = document.createElement('td');
        tdTag.setAttribute('class', 'td' + (i + 1));
        let text = document.createTextNode(arguments);

        tdTag.appendChild(text);
        trTag.appendChild(tdTag);


    }
    // 체크박스 요소 추가
    let td = document.createElement('td');
    let checkbox = document.createElement('input');
    checkbox.setAttribute('type', 'chechbox');
    td.appendChild(checkbox);
    trTag.appendChild(td);
    return trTag;
}

// 기존생성되어있는 tr에 이벤트 등록.
function addTrEvent() {
    let trs = document.querySelectorAll('#list > tbody > tr'); // 하위요소 찾기
    console.log(trs);
    for (let i = 0; i < trs.length; i++) {
        trs[i].addEventListener('click', function () {
            console.log('내용:', this.children[2].innerHTML);
            // form  화면의 각 요소의 값 <= this.children[2].innerHTML
            document.getElementById('num').value = this.children[0].innerHTML;
            document.getElementById('title').value = this.children[1].innerHTML;
            document.getElementById('writer').value = this.children[2].innerHTML;
            document.getElementById('regDate').value = this.children[3].innerHTML;

        }); // 매게값 (event, function);
    }
}
// 수정버튼을 클릭하면 실행될 eventHandler(코드)
let updateBtn = document.querySelector('#inputForm > form > input[type="button"]');
console.log(updateBtn);
updateBtn.addEventListener('click', function () {
    //폼태그 안에 사용자가 수정한 값을 테이블에서 찾아와서 (tr=id)하위요소 변경.
    let numInput = document.getElementById('num');
    let titleInput = document.getElementById('title');
    let writerInput = document.getElementById('writer').value;
    let regDateInput = document.getElementById('regDate');

    console.log(numInput.value); // 수정하고자 하는 게시판의 글번호
    let searchId = numInput.value;
    let findTr = document.getElementById(searchId);
    console.log(findTr);
    // 제목:
    findTr.children[1].innerHTML = titleInput.value;
    // 이름:
    findTr.children[2].innerHTML = writerInput.value;
    // 날짜:
    findTr.children[3].innerHTML = regDateInput.value;


});

//선택삭제 버튼 클릭 선택값만 삭제처리
document.getElementById('delBtn').addEventListener('click', function () {
    // 체크박스가 선택 요소 가져와야함
    let checkedBox = document.querySelectorAll('#list > tbody> tr > td > input[type="checkbox"]:checked');
    console.log(checkedBox);
    for (let i = 0; i < checkedBox.length; i++) {
        checkedBox[i].parentNode.parentNode.remove();
    }
});
// 남은 데이터 tr 건수만큼 가져와서 class => altRow;
let remainTr = document.querySelectorAll('#list > tbody > tr');
for (let i = 0; i < remainTr.length; i++) {
    if (i % 2 == 1) {
        remainTr[i].className = 'altRow';
    } else {
        remainTr[i].className = '';
    }
}