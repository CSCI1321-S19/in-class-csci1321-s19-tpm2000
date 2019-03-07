package videoCode

import java.io.DataOutputStream
import java.io.FileOutputStream
import java.io.BufferedOutputStream

object LoanPattern {
  def withDOS[A](filename:String)(body: DataOutputStream => A) : A = {
    val dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))
    try {
      body(dos)
    } finally {
      dos.close()
    }
  }
}