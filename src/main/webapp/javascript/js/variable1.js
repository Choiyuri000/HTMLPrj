// js.variable1.js

const numbers = [23, 44, 18, 35, 50];
        numbers.push(42);
        let sum = 0;
        for (let i = 0; i < numbers.length; i++) {
            console.log(numbers[i]);
            sum += numbers[i];
        }
        console.log(sum);
        document.write('<ul>');
        document.write(numbers[0]);
        for (let i = 1; i < numbers.length; i++) {
            document.write(' <tr>' + '<br>' + '+' + numbers[i] + '</tr>' +'</br>');
        }
        document.write('합계' + sum);
        document.write('</ul>');