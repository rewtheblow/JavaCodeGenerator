package jp.ac.aiit.gen


import java.io.PrintWriter
import org.apache.velocity.Template
import org.apache.velocity.VelocityContext
import org.apache.velocity.app.VelocityEngine
import org.apache.velocity.exception.MethodInvocationException
import org.apache.velocity.exception.ParseErrorException
import org.apache.velocity.exception.ResourceNotFoundException;
import jp.ac.aiit.gen.entity.Member

object Main {

  def main(args: Array[String]): Unit = {
    println("program start")
   
    // データの作成
//    val members	= List("Atsuki", "Shota", "Ryu")
//    val members		= Array("Atsuki", "Shota", "Ryu")
    var members = Array(new Member("しょー", "SE", Array("ソフトウェア開発プロセス特論")),
    					new Member("りゅー", "プログラマ", Array("ソフトウェア工学特論","システムモデリング特論"))
    					)
    println ("Data set")
    
	// Velocity を利用して、テンプレートファイル上にデータを展開し、ファイルに出力
	val velWrapper = new VelocityWrapper("./template/template.vm");				// Velocity のラッパークラスのオブジェクトを生成　※ラッパーオブジェクトの詳細はロジック追う必要はないかと
	velWrapper.put("members", members);											// データをセットした members オブジェクトを、テンプレートファイル上の "members" と関連付ける
	val result = velWrapper.merge();											// テンプレート上にデータを展開し、ひとつの文字列オブジェクトとする
	System.out.println("Memberクラスのオブジェクトの情報を、./template/template.vmのテンプレートファイル上に展開しました");
	val pw	= new PrintWriter("output.xml", "UTF-8");
	pw.print(result);															// 文字列オブジェクトをファイルに出力
	System.out.println("展開した情報を、./output.xmlとして出力しました");
	pw.close();
    
    println("program end")
  }
  
}