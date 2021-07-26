// js/variable.js
let var1 = 'Hello';

var1 = 'World'; // string 
var1 = 100;
var1 = true;
console.log(typeof var1);

let var11 = 10;
console.log(var11);

const con1 = 'Good'; // 상수
// con1 = 'Moning';-> 에러

let num1 = 1;
let num2 = 1;
console.log(num1 * num2);

document.write('<h1>Hello</h1>');
document.write('<ul>');
document.write(' <li>Apple</li>')
document.write(' <li>Banana</li>')
document.write('</ul>')

let str = '<ul>';
str += '  <li>Orange</li>';
str += '  <li>Mango</li>';
str += '</ul>'
document.write(str);

let fruits = ['수박', '딸기', '복숭아'];
fruits = new Array(); //->오브젝트(인스턴스화 유사)
fruits.push('수박');
fruits.push('딸기');
fruits[2] = '복숭아';
fruits[fruits.length] = '옥수수';
fruits[fruits.length] = '감자';
fruits.pop(); // 마지막 위치 삭제.
fruits.pop();
fruits.unshift('옥수수'); // 첫번째 추가 삽입 
fruits.shift(); // 첫번째 삭제. 

console.log(typeof fruits); // 클래스 인스턴스와 유사

document.write('<ul>');
for (let i = 0; i < fruits.length; i++) {
    document.write('<li>' + fruits[i] + '</li>');
}
document.write('</ul>');