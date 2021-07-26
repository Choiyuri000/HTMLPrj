  // 학생 이름, 국어, 수학, 영어  => student1 오브젝트.
  const student1 = {
      name: '김길동',
      kor: 80,
      math: 60,
      eng: 70
  }
  const student2 = {
      name: '서길동',
      kor: 80,
      math: 90,
      eng: 70
  }
  const student3 = {
      name: '황길동',
      kor: 70,
      math: 90,
      eng: 60
  }
  const students = [student1, student2, student3];
  students.push(student1);
  students.push(student2);
  students.push(student3);

  const fields = {
      name: '학생이름',
      kor: '국어점수',
      math: '수학점수',
      eng: '영어점수'
  }

  document.write('<table border="1">');
  document.write('<thead><tr>');
  for (field in fields) {
      document.write('<th>' + fields[field] + '</th>');
  }
  document.write('</tr></thead>');

  document.write('<tbody><tr>');
  for (let i = 0; i < students.length; i++) {
      for (field in fields) {
          document.write('<td>'+students[i][field]+'</td>');
          
        }
  }
  document.write('</tr></tbody>');



 
 
  
  document.write('</table>');