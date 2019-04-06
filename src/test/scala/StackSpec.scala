import org.scalatest._

class StackSpec extends FlatSpec with DiagrammedAssertions {

  "push、pop関数" should "要素を追加して取り出す" in {
    val stack: Stack[Int] = Stack().push(1).push(2)
    val (poped1, rest1) = stack.pop
    val (poped2, rest2) = rest1.pop
    assert(poped1 == 2)
    assert(poped2 == 1)
    assert(rest2 == EmptyStack)
  }

  it should "空のStackのpopメソッドを呼び出すと実行時例外が投げられる" in {
    intercept[IllegalArgumentException] {
      Stack().pop
    }
  }

  "isEmpty関数" should "空であるかの真偽値を返す" in {
    val stack: Stack[Int] = Stack().push(1)
    val empty: Stack[Int] = Stack()
    assert(stack.isEmpty == false)
    assert(empty.isEmpty == true)
  }
}
