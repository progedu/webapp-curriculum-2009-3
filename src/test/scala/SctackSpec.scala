import org.scalatest._

class StackSpec extends FlatSpec with DiagrammedAssertions {
  
  it should "isEmptyは空のStackはtrue,空でないStackはfalseを返す" in {
    assert(EmptyStack.isEmpty)
    assert(!EmptyStack.push(1).isEmpty)
  }

  it should "LIFOの動作をする" in {
    val stack = Stack()
    val first = stack.push(1)
    val second = first.push(2)
    assert(second.pop._1 == 2)
    assert(second.pop._2.pop._1 == 1)
  }

  it should "空のStackからpopしようとすると実行時例外が投げられる" in {
    intercept[IllegalArgumentException] {
      EmptyStack.pop
    }
  }
}

