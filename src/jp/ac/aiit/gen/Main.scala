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
   
    // �f�[�^�̍쐬
//    val members	= List("Atsuki", "Shota", "Ryu")
//    val members		= Array("Atsuki", "Shota", "Ryu")
    var members = Array(new Member("����[", "SE", Array("�\�t�g�E�F�A�J���v���Z�X���_")),
    					new Member("���[", "�v���O���}", Array("�\�t�g�E�F�A�H�w���_","�V�X�e�����f�����O���_"))
    					)
    println ("Data set")
    
	// Velocity �𗘗p���āA�e���v���[�g�t�@�C����Ƀf�[�^��W�J���A�t�@�C���ɏo��
	val velWrapper = new VelocityWrapper("./template/template.vm");				// Velocity �̃��b�p�[�N���X�̃I�u�W�F�N�g�𐶐��@�����b�p�[�I�u�W�F�N�g�̏ڍׂ̓��W�b�N�ǂ��K�v�͂Ȃ�����
	velWrapper.put("members", members);											// �f�[�^���Z�b�g���� members �I�u�W�F�N�g���A�e���v���[�g�t�@�C����� "members" �Ɗ֘A�t����
	val result = velWrapper.merge();											// �e���v���[�g��Ƀf�[�^��W�J���A�ЂƂ̕�����I�u�W�F�N�g�Ƃ���
	System.out.println("Member�N���X�̃I�u�W�F�N�g�̏����A./template/template.vm�̃e���v���[�g�t�@�C����ɓW�J���܂���");
	val pw	= new PrintWriter("output.xml", "UTF-8");
	pw.print(result);															// ������I�u�W�F�N�g���t�@�C���ɏo��
	System.out.println("�W�J���������A./output.xml�Ƃ��ďo�͂��܂���");
	pw.close();
    
    println("program end")
  }
  
}