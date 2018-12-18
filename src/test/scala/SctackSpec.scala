import org.scalatest._

class NumberFormatterSpec extends FlatSpec with DiagrammedAssertions {

  "apply関数" should "EmptyStackを生成する" in {
    assert(Stack() === EmptyStack )
  }

  val empty = Stack()

  "new NonEmptyStack" should "NonEmptyStackを生成する" in {
    assert(new NonEmptyStack(1, empty).isInstanceOf[Stack[Int]] === true)
    assert(new NonEmptyStack[Int](1, empty).isInstanceOf[Stack[Int]] === true)
  }

  "push関数" should "EmptyStackからNonEmptyStackになる" in {
    assert(empty.push(1).isInstanceOf[Stack[Int]] === true)
  }

  val nonEmpty = empty.push(1)

  "pop関数" should "値を取り出すことができる" in {
    assert(nonEmpty.pop._1 === 1)
  }
  "push関数" should "値を追加できる" in {
    assert(nonEmpty.push(2).pop._1 == 2)
  }

  "isEmpty関数" should "EmptyStackとNonEmptyStackを正しく判別できる" in {
    assert(empty.isEmpty === true)
    assert(nonEmpty.isEmpty === false)
  }

  it should "EmptyStackから値を取り出そうとしたら実行時例外が投げられる" in {
    intercept[IllegalArgumentException] {
      empty.pop
    }
  }

}

