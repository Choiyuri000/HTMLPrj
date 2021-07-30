const numbers = [23, 43, 77, 88, 65];
for (let i = 0; i < numbers.length; i++) {
    console.log(numbers[i]);
}
for (let num of numbers) { //반복
    console.log(num);
}
let sum = 0;
let fData = numbers.filter(function (val, idx) { //배열
    return val > 40;
});
console.log(`fData: ${fData}`);

mData = fData.map(function (val, idx) {
    return val * 2;
});
console.log(`mData: ${mData}`);
mData.forEach(sumCallBack);

function sumCallBack(v, i) {

    sum += v;

};
console.log(`합계 : ${sum}`);
console.log('==========');
numbers.filter(function (val, idx) {
        return val > 40;
    })
    .map(function (val, idx) {
        return val * 2;
    })
    .forEach(function (val, idx) {
        console.log(`val: ${val}, idx: ${idx}`);
    });
console.log('==========');