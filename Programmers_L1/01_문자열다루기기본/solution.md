# 문자열 다루기 기본

Tags: String, javascript, level1
날짜: Sep 22, 2020

## **문제 설명**

---

문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.

**제한 사항:** 

- `s`는 길이 1 이상, 길이 8 이하인 문자열입니다.

**예시:**

```jsx
solution("a234"); //false
solution("1234"); //true
```

## 해결과정 1

---
**사용언어:** JavaScript

제한사항, 길이체크, 정수체크를 만족하도록 코드를 작성했다.

```jsx
function solution(s) {
    var answer = false;
    if(1<=s.length<=8){
        if((s.length==4||s.length==6)&&Number.isInteger(parseInt(s))){
        var answer = true;
    }
    return answer;
    }
}
```

**테스트 결과:**

```jsx
/*
채점 결과
정확성: 87.5
합계: 87.5 / 100.0
*/
```

테스트 3, 11 실패. 공백 테스트해볼 것