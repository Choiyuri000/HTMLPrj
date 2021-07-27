function sum(){

} // 중간에 있더라도 전체적용가능
let a = 10;
console.log(a);

function cal() {
    let num1 = document.getElementById('num1');
    let num2 = document.getElementById('num2');

    console.log(Number(num1.value) + Number(num2.value));
    let result = document.getElementById('result');
    result.value = fnc(Number(num1.value), Number(num2.value));
}

console.log('function정의 전 : ' + sum(10,20));
let fnc = function (a, b) {
    return a + b;
} // 많이 쓰임 
console.log('function정의 전 : ' + fnc(10,20));

console.log(fnc(10,20));

function sum(num1, num2) { // hoisting: function 정의구문을 끌어올림
    return num1 + num2;
}
let result = sum(10, 20);
console.log(result);
result = sum('Hello', 'World');
console.log(result);