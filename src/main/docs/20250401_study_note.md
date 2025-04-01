# Study Note - 1회차
* 일시: 2025.04.01(화) 18:00 - 18:40
* 주제: Section 06. Stack, 07. Queue

### 1. Stack, Queue
* 배열 + 인덱스 활용 혹은 리스트으로 풀 수 있는 경우가 종종 있음
* 스택 또는 큐가 의미 있게 쓰이는 경우
  * 스택: 짝 지어 없어질 때
  * 큐: 꺼내온 값이 의미 있을 때

#### `ArrayDeque`
1. `LinkedList`로 구현된 큐에 비해 삽입 성능이 좋음 (배열 기반)
2. 인터페이스 `Queue`와 `Deque`를 구현
   * `Deque` 인터페이스 주요 메서드: `push()`, `pop()`, `offer()`, `poll()` 등
     * 따라서 스택, 큐, 덱 문제에 모두 활용 가능
     * 아래와 같이 `Queue`로 변수 선언 시 Queue에 필요한 메서드만 활용 가능 (Recall. OOP 3대 특징 > 다형성)
```java
import java.util.ArrayDeque;

class Main {
    Queue<Integer> queue = new ArrayDeque<>();
    // ArrayDeque<E> implements Deque<E>
    // Deque<E> extends Queue<E>
}
```

### 2. 문제 풀이 관련
#### 문제 08. 올바른 괄호
1. 스택 이용: 유지보수성
2. `int` 카운터 변수 이용: 성능

#### 문제 09. 10진수를 2진수로 변환하기
1. 스택 이용
2. `StringBuilder`의 `insert()` 메서드 활용
3. java API 활용: `toBinaryString()`

#### 문제 12. 주식 가격
* 스택을 사용하면 된다는 것을 파악하기 어려웠던 문제
* $O(N^2)$ 브루트 포스로 풀어도 프로그래머스 테스트는 통과

#### 문제 13. 크레인 인형 뽑기 게임
* 각각의 lane을 스택으로 만들지 않아도 풀 수 있음

#### 문제 14. 표 편집
* 아이디어 떠올리기 어려운 문제
* 핵심 아이디어
  * soft delete
  * `LinkedList`스러운 배열 및 인덱스 활용

#### 문제 16. 기능 개발
* 코드에서는 사실상 큐가 전혀 쓰이지 않음
  * `add`하고 순회하며 출력 -> 리스트로 대체 가능
  * `문제 분석하고 풀기`에서 큐 등장