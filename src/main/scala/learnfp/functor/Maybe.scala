package learnfp.functor

object Maybe {
  sealed trait Maybe[+A]
  case class Just[A](value: A) extends Maybe[A]
  object Just {
    def fmap[A, B](a: Just[A])(fx: A => B): Just[B] = Just[B](fx(a.value))
  }

  case class Nothing[A]() extends Maybe[A]
  object Nothing {
    def fmap[A, B](a: Nothing[A])(fx: A => B): Nothing[B] = Nothing[B]()
  }
}

object MaybeInstance {
  import Maybe._
  implicit val justInstance:Functor[Just] = new Functor[Just] {
    override def fmap[A, B](a: Just[A])(fx: A => B): Just[B] = Just.fmap(a)(fx)
  }
  implicit def nothingInstance = new Functor[Nothing] {
    override def fmap[A, B](a: Nothing[A])(fx: A => B): Nothing[B] = Nothing.fmap(a)(fx)
  }
  implicit val maybeInstance:Functor[Maybe] = new Functor[Maybe] {
    override def fmap[A, B](a: Maybe[A])(fx: A => B): Maybe[B] = a match {
      case at:Nothing[A] => Nothing.fmap(at)(fx)
      case at:Just[A] => Just.fmap(at)(fx)
    }
  }
}
