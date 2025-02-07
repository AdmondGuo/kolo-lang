package tech.mlsql.ets.register

import tech.mlsql.runtime.AppRuntimeStore

import scala.collection.JavaConverters._
import scala.collection.concurrent


/**
 * 2019-04-12 WilliamZhu(allwefantasy@gmail.com)
 */
object ETRegister {
  private val mapping = new java.util.concurrent.ConcurrentHashMap[String, String]()

  def wow(name: String) = mapping.put(name, ("tech.mlsql.ets." + name))

  def register(name: String, value: String) = mapping.put(name, value)

  def remove(name: String) = mapping.remove(name)

  /**
   * @return et mapping
   * @see If you need to get all the ET, you should use the function [[tech.mlsql.dsl.adaptor.MLMapping.getETMapping]],
   *      because there are still registrations using MLMapping.
   */
  def getMapping: concurrent.Map[String, String] = {
    mapping.asScala
  }


  wow("ShowCommand")
  wow("EngineResource")
  wow("HDFSCommand")
  wow("NothingET")
  wow("ModelCommand")
  wow("MLSQLEventCommand")
  wow("KafkaCommand")
  wow("DeltaCompactionCommand")
  wow("DeltaCommandWrapper")
  wow("ShowTablesExt")
  register("DTF", "tech.mlsql.ets.tensorflow.DistributedTensorflow")
  wow("PythonCommand")
  wow("SchedulerCommand")
  wow("PluginCommand")
  wow("Ray")
  wow("RunScript")
  wow("PrintCommand")
  wow("IteratorCommand")

  register("IfCommand", "tech.mlsql.ets.ifstmt.IfCommand")
  register("ElifCommand", "tech.mlsql.ets.ifstmt.ElifCommand")
  register("ThenCommand", "tech.mlsql.ets.ifstmt.ThenCommand")
  register("FiCommand", "tech.mlsql.ets.ifstmt.FiCommand")
  register("ElseCommand", "tech.mlsql.ets.ifstmt.ElseCommand")

  register("XGBoostExt", "tech.mlsql.ets.XGBoostExt")

  
  AppRuntimeStore.store.registerResultRender("ShowFileTable", "tech.mlsql.ets.ShowFileTable")

}
