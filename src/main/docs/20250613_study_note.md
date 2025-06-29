# Study Note - 6회차
* 일시: 2025.06.13(금) 18:00 - 19:00
* 주제: Section 12. Backtracking
* 참가자: 곽진웅, 김운경, 정유진

### 1. Backtracking
유망함수를 정의하여 해가 될 가능성이 없는 곳에서는 되돌아가는 방식으로 해를 찾는 알고리즘

### 2. 문제 풀이 요약
#### 문제 46. N-퀸
* 대표적인 백트래킹 유형 중 하나
* 행이나 열을 하나씩 늘려가며 퀸의 배치 가능한 자리를 탐색
* 대각선 처리
  * 저자 방법: `diag1`, `diag2` 배열 생각
  * 다른 방법: `Math.abs` 이용 (이 방법이 더 깔끔한 듯)

#### 문제 47. 양궁 대회
* 백트래킹에 추가로 가장 낮은 점수를 많이 맞힌 경우를 반환해야 하는 부분을 고려

<!--
### 3. 기타 문제 메모
#### 문제 48. 외벽 점검
오름차순 정렬 대신 내림차순 정렬을 생각하는 게 더 직관적이지만 코드 구현이 어려울 수 있음
-->