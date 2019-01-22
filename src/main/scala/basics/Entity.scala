package basics

class Entity (
  private var x: Double,
  private var y: Double
) {
  private val width = 1.0
  private val height = 1.0
  
  def intersects(e: Entity): Boolean = {
    val overLapX = (x-e.x).abs < (width + e.width)/2
    val overLapY = (y-e.y).abs < (height + e.height)/2
    overLapX && overLapY
  }
}

object Entity{
  def main(args:Array[String]):Unit={
    val e1 = new Entity(0,0)
    val e2 = new Entity(0,0)
    println(e1.intersects(e2))
    val e3 = new Entity(10,0)
    println(e1.intersects(e3))
  }
}