import org.scalatest._

class SctackSpec extends FlatSpec with DiagrammedAssertions {

  it should "EmptyStackが作れる" in {
    assert(Stack() === EmptyStack)
    assert(Stack().isEmpty === true)
  }

  it should "NonEmptyStackが作れる" in {
    val NonEmpStack = Stack().push(1)
    assert(NonEmpStack.isEmpty === false)
  }

  "pop,pushメソッド" should "値を追加し、順番通りに取り出せる" in {
    val EmpStack = Stack()
    val NonEmpStack = EmpStack.push(1).push(2)
    assert(NonEmpStack.pop._1 === 2)
  }

  it should "popする値がない時はエラーが投げられる" in {
    val EmpStack = Stack()
    intercept[IllegalArgumentException] {
      EmpStack.pop
    }
  }

}

