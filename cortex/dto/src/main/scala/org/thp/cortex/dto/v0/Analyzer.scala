package org.thp.cortex.dto.v0

import io.scalaland.chimney.dsl._
import org.thp.cortex.dto.client.OutputCortexAnalyzer
import play.api.libs.json.{Json, OFormat}

case class InputAnalyzer(
    name: String,
    description: String,
    dataTypeList: Seq[String]
)

object InputAnalyzer {
  implicit val format: OFormat[InputAnalyzer] = Json.format[InputAnalyzer]
}

case class OutputAnalyzer(
    id: String,
    name: String,
    version: String,
    description: String,
    dataTypeList: Seq[String],
    cortexIds: List[String] = Nil
)

object OutputAnalyzer {
  implicit val format: OFormat[OutputAnalyzer] = Json.format[OutputAnalyzer]
}

trait AnalyzerConversion {
  def toOutputAnalyzer(a: OutputCortexAnalyzer): OutputAnalyzer = a.into[OutputAnalyzer].transform
}