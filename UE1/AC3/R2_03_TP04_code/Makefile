all : couleurConstructeurCopie imageSetPixel01 imageSetPixel02 imageConstructeurCopie imageNiveauGris imageNegatif imageDifference01 imageDifference02 clean

couleurConstructeurCopie :
	@javac TestCouleurConstructeurCopie.java
	@java TestCouleurConstructeurCopie

imageSetPixel01 :
	@javac TestImageSetPixel01.java
	@java TestImageSetPixel01

imageSetPixel02 :
	@javac TestImageSetPixel02.java
	@java TestImageSetPixel02

imageConstructeurCopie :
	@javac TestImageConstructeurCopie.java
	@java TestImageConstructeurCopie

imageNiveauGris :
	@javac TestImageNiveauGris.java
	@java TestImageNiveauGris

imageNegatif :
	@javac TestImageNegatif.java
	@java TestImageNegatif

imageDifference01 :
	@javac TestImageDifference01.java
	@java TestImageDifference01

imageDifference02 :
	@javac TestImageDifference02.java
	@java TestImageDifference02

doc :
	javadoc -d doc Couleur.java Image.java

clean :
	@rm -rf *~ *.class doc
