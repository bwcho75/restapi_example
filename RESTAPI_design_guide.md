## 동사보다는 명사를 사용하자

#### URL을 심플하고 직관적으로 만들자
REST API를 URL만 보고도, 직관적으로 이해할 수 있어야 한다
URL을 길게 만드는것 보다, 최대 2 depth 정도로 간단하게 만드는 것이 이해하기 편하다.
> /dogs 
> /dogs/1234

#### URL에 동사보다는 명사를 사용한다.
REST API는 리소스에 대해서 행동을 정의하는 형태를 사용한다. 예를 들어서 
> POST /dogs

는 /dogs라는 리소스를 생성하라는 의미로, URL은 HTTP Method에 의해 CRUD (생성,읽기,수정,삭제)의 대상이 되는 개체(명사)라야 한다.
잘못된 예들을 보면
> HTTP Post : /getDogs 
> HTTP Post : /setDogsOwner 

위의 예제는 행위를 HTTP Post로 정의하지 않고, get/set 등의 행위를 URL에 붙인 경우인데, 좋지 않은 예 이다. 이보다는
> HTTP Get : /dogs 
> HTTP Post : /dogs/{puppy}/owner/{terry}

를 사용하는 것이 좋다.
일반적으로 권고되는 디자인은 다음과 같다.

| 리소스  | POST | GET | PUT | DELETE |
|--------|--------|--------|--------|--------|
|        | create | read | update | delete |
| /dogs|새로운 dogs 등록|dogs 목록을 리턴|Bulk로 여러 dogs 정보를 업데이트 | 모든 dogs 정보를 삭제 |
| /dogs/baduk | 에러| baduk 이라는 이름의 dogs 정보를 리턴 | baduk이라는 이름의 dogs 정보를 업데이트 | baduk 이라는 이름의 dogs 정보를 삭제|

### 단수(Singular) 보다는 복수(Plural)형 명상를 사용한다.

되도록이면 추상적인 이름보다 구체적인 이름을 사용하자

### 리소스간의 관계를 표현하는 방법

##### Option A.
다른 리소스와의 관계를 표현. 예를 들어 owner가 가지고 있는 개(dogs) 목록
> GET /owner/{terry}/dogs

와 같이 /resource명/identifier/other-related-resource 형태로, 해당 리소스에 대한 경로를 /resource명/{그 리소스에 대한 identifier}/{연관되는 다른 리소스 other-related-resource} 형태로 표현한다.

##### Option B.
https://usergrid.incubator.apache.org/docs/relationships/ 에 보면 다른 형태의 관계 정의 방법에 대해서 나와 있는데, 조금 더 구체적인 API 관계 정의 방법은 다음과 같다.
> /resource/identifier/relation/other-related-resource
> GET /owner/terry/likes/dogs

이 방식이 조금 더 명시적일 수 있다. 리소스간의 관계가 복잡하지 않은 서비스의 경우에는 Option A를, 리소스간의 관계가 다소 복잡한 경우에는 Option B를 사용하도록 한다. 


### 에러 처리

### 버전 관리

### 페이징 처리

### 검색

### 인증




-
