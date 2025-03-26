# Study Note - 1회차
* 일시: 2025.03.26(수) 18:00 - 18:40
* 주제: Section 05. Array

### 1. 코드 스타일
코드 작성 시 고려할 점
* 가독성, 유지보수성 (객체 지향)
* 간결함, 다양한 툴 활용
* 성능 (시간/공간 복잡도)

기업마다 원하는 코드 스타일이 상이하므로 다양한 스타일로 짜보면 좋다. (지망 기업의 선호 스타일 위주로?)

### 2. Stream
* 사용했을 때 성능이 좋은 경우도 있지만 주된 장점은 가독성, 편의성 등 (단순 순회 등은 배열의 성능이 더 좋을 수 있음)

* 예시: 배열에서 maximum 구하기
```java
public class Max {
    public static void main(String[] args) {
        System.out.println(max(new int[] {1,2,7,4,5}));
        System.out.println(getMax(new int[] {1,2,7,4,5}));
    }
    
    public static int max(int[] nums) { // 배열
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static int getMax(int[] nums) { // 스트림
        return Arrays.stream(nums)
                .max()
                .orElse(Integer.MIN_VALUE);
    }
}
```

### 3. 문제 풀이 관련
#### 2번 문제
1. `HashSet` 이용한 후 정렬
    * 삽입: $O(1)$ 연산 $N$번 -> $O(N)$
    * 정렬: $O(N\log N)$
2. `TreeSet` 이용
    * 삽입: $O(\log N)$ 연산 $N$번 -> $O(N\log N)$
3. 스트림 이용
  
##### `HashSet` vs `TreeSet`
chatGPT 의견: 정렬된 상태의 데이터가 필요하면 `TreeSet`, 마지막에 한 번만 정렬한다면 `HashSet`이 더 좋다.

#### 6번 문제
정렬 기준 여러 개일 때 사용할 수 있는 방법 
1. 메서드 오버라이딩
2. `Comparator` + `thenComparing`

#### 7번 문제
* 풀이에 쓰인 아이디어를 생각해보면 그래프 개념 문제로 볼 수 있음
* 배열을 이용한 풀이도 가능하다.

### 4. 기타
* `String` 자유자재로 가공할 수 있게 연습하면 좋다.
* 풀고 나서 저자의 풀이, 다른 스터디원의 코드도 참고해보면 좋다.
* 특정 기능이 자바 어떤 버전에서 추가되었는지도 알아두면 좋다. (혹은 대체할 방법을 함께 알아두거나)
    * 예시: 백준의 경우 Java 8, 11만 지원하므로 아래와 같은 문법 사용 불가
    ```java
    switch (dir) {
    // Java 12에서 "프리뷰 기능"으로 도입
    // Java 14부터 정식 도입
        case 'U' -> movedY += 1;
        case 'D' -> movedY -= 1;
        case 'L' -> movedX -= 1;
        case 'R' -> movedX += 1;
    }
    ```