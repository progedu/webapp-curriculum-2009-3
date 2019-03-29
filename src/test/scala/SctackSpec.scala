import org.scalatest._

class NumberFormatterSpec extends FlatSpec with DiagrammedAssertions {

  "apply関数" should "EmptyStackを作成できる" in {
    val stack = Stack()
    assert(stack === EmptyStack)
  }

  "push関数" should "EmptyStackにpushすることで、NonEmptyStackを作成できる" in {
    val stack = Stack()
    val pushedStack = stack.push(1)
    assert(pushedStack.isInstanceOf[NonEmptyStack[Int]])
  }

  "pop関数" should "最後にpushした要素から取り出される" in {
    val stack = Stack()
    val pushedStack1 = stack.push(1)
    val pushedStack2 = pushedStack1.push(2)

    val (top1, rest1) = pushedStack1.pop
    val (top2, rest2) = pushedStack2.pop
    val (top3, rest3) = rest2.pop

    assert(top1 === 1)
    assert(rest1 === EmptyStack)
    assert(top2 === 2)
    assert(rest2 === pushedStack1)
    assert(top3 === 1)
    assert(rest3 === EmptyStack)
  }

  it should "EmptyStackにpopをした場合、例外が投げられる" in {
    val stack = Stack()
    intercept[IllegalArgumentException] {
      stack.pop
    }
  }

  "isEmpty関数" should "要素の有無を取得できる" in {
    val stack = Stack()
    val pushedStack = stack.push(1)

    assert(stack.isEmpty === true)
    assert(pushedStack.isEmpty === false)
  }

}

