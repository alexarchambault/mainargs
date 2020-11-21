package mainargs
import scala.annotation.tailrec

/**
 * Models what is known by the router about a single argument: that it has
 * a [[name]], a human-readable [[typeString]] describing what the type is
 * (just for logging and reading, not a replacement for a `TypeTag`) and
 * possible a function that can compute its default value
 */
case class ArgSig[B](name: String,
                     shortName: Option[Char],
                     doc: Option[String],
                     default: Option[B => Any],
                     varargs: Boolean,
                     flag: Boolean,
                     reader: ArgParser[_]){
  def typeString = reader.shortName
}
