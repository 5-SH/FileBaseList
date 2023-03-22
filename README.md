# 1억 개 이상의 elements 를 갖는 List 구현

Binary Sequence File 로 구현    

```
[List Size|   idx   |  value  |   idx   |  value  |   idx   |  value  | ... ]
[ 4 bytes | 4 bytes | 4 bytes | 4 bytes | 4 bytes | 4 bytes | 4 bytes | ... ]

idx + value (8 bytes) = Element
```