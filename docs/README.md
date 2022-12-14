# 기능 목록 정리

1. 자판기가 보유하고 있는 금액을 입력 받는다.
   - 금액은 숫자로만 입력 받으며, 금액 단위인 쉼표(,)는 허용한다.
   - 금액의 범위는 (10 ~ 2,147,483,640) 이며, 10의 배수이다.
2. 자판기 보유 금액으로 동전을 무작위로 생성한다.
   - 생성할 동전의 단위는 500, 100, 50, 10원이다.
3. 자판기가 보유한 동전 내역을 출력한다.
4. 자판기가 판매할 상품 정보를 입력받는다.
   - 상품 정보는 상품명, 가격, 수량이며 쉼표(,)로 구분한다.
   - 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분한다.
   - `ex) [콜라,1500,20];[사이다,1000,10]`
   - 상품 가격의 범위는 (100 ~ 100,000) 이며, 10의 배수여야 한다.
   - 상품 수량은 (1 ~ 100,000) 이다.
5. 사용자에게 투입 금액을 입력 받는다.
   - 금액은 숫자로만 입력 받으며, 금액 단위인 쉼표(,)는 허용한다.
   - 금액의 범위는 (10 ~ 2,147,483,640) 이다.
6. 남은 금액을 출력한다.
7. 구매할 상품명을 입력 받는다.
8. 남은 금액이 상품의 최저 가격보다 많고, 판매할 상품이 남아 있다면 (6 ~ 7) 과정을 반복한다.<br/>
   그렇지 않으면 바로 잔돈을 돌려준다.
   - 잔돈은 최소한의 동전 갯수로 반환해야 한다.
   - 잔돈보다 자판기 보유 금액이 적으면, 보유 금액을 모두 반환한다.


## 패키지 구조

```
(vendingmachine)
├── (model)
│   ├── (data)
│   │   ├── (coin)
│   │   │   ├── Coin.kt
│   │   │   ├── CoinBox.kt
│   │   │   ├── CoinExchanger.kt
│   │   │   ├── MutableCoinBox.kt
│   │   │   └── MutableCoinBoxImpl.kt
│   │   │   
│   │   └── (product)
│   │       ├── Product.kt
│   │       ├── ProductInfo.kt
│   │       └── ProductMap.kt
│   │       
│   ├── (random)
│   │   ├── RandomGenerator.kt
│   │   └── RandomNumberGenerator.kt
│   │   
│   └── (repository)
│       ├── Result.kt
│       └── VendingMachineRepository.kt
│       
├── (util)
│   └── CollectionsExt.kt
│   
├── (view)
│   ├── (io)
│   │   ├── InputView.kt
│   │   └── OutputView.kt
│   │   
│   ├── (strings)
│   │   ├── ErrorMessage.kt
│   │   └── Message.kt
│   │   
│   └── VendingMachineView.kt
│   
├── (viewmodel)
│   └── VendingMachineViewModel.kt
│   
└── Application.kt 
```