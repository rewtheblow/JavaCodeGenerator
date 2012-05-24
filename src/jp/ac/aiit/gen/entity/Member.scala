package jp.ac.aiit.gen.entity

class Member(	val name: String,
				val occupation: String,
				val favoriteLessons: Array[String]) {
	def getName				= name
	def getOccupation		= occupation
	def getFavoriteLessons	= favoriteLessons 
}