let alphabet = new Array(26);
let ch = "A";
console.log(ch);
ch = ch.charCodeAt(0);
console.log(ch);

// 알파벳의 아스키 코드를 저장
for(let i = 0; i<alphabet.length; i++){
    alphabet[i] = ch + i;
}
console.log(alphabet)

// 알파벳의 아스키 코드를 출력
for(let i = 0; i<alphabet.length; i++){
    console.log(String.fromCharCode(alphabet[i]) + " ascii = " + alphabet[i]);
}
console.log(alphabet)

