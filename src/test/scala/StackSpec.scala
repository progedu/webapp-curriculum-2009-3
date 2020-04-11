import org.scalatest._

class StackSpec extends FlatSpec with DiagrammedAssertions {

  val empty_stack: Stack[Nothing] = Stack()

  "empty stack" should "raise error with pop" in {
    intercept[IllegalArgumentException] {
      empty_stack.pop
    }
  }

  it should "スタックにデータを入れられる" in {
    assert(empty_stack.isEmpty === true)

    val pushed1 = empty_stack.push(1)
    val pushed2 = pushed1.push(2)
    val (poped, rest) = pushed2.pop

    assert(pushed1.isEmpty === false)
    assert(poped === 2)
    assert(rest === pushed1)
  }
}
