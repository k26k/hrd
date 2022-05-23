const RATE_KPH_MPH = 1.609;
let kph = 0 , mph = 0;
kph = parseFloat(prompt("당신의 구속을 입력하세요(km/h)", "100"));
mph = kph * RATE_KPH_MPH;
document.write("당신의 구속 " + kph + "km/h는 " + mph + "mile/h입니다.<br>");
document.write("당신의 구속 " + kph + "km/h는 " + mph.toFixed(2) + "mile/h입니다.");