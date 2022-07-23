package ccom.alura.stickers;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ExtratorMarvel implements ExtratorDeConteudo{
//	https://blueimp.github.io/JavaScript-MD5/
	String timeStamp= "1565045589";
	String ts= "8a5f5f841e92640ebb4828a4d6cb2bdc";
//	8a5f5f841e92640ebb4828a4d6cb2bdc
//	aa2280622171e5b4ace48242b11e867c
	String apiKey="21970e9776e65561b9bf86cba10886f9"; //  public key
//	https://gateway.marvel.com:443/v1/public/comics/4/characters?apikey=1ae0dac9e1b6c414ddd5adaaf1ae1d97ac9067dd
//	For example, a user with a public key of "1234" and a private key of "abcd" could construct a valid call as follows: http://gateway.marvel.com/v1/public/comics?ts=1&apikey=1234&hash=ffd275c5130566a2916217b101f26150 (the hash value is the md5 digest of 1abcd1234)
	String chavePrivada="1ae0dac9e1b6c414ddd5adaaf1ae1d97ac9067dd";
	String base= "https://gateway.marvel.com:443/v1/public/comics/48/characters?"
			+ "ts="+ts+"&apikey="+apiKey+"&hash=aa2280622171e5b4ace48242b11e867c&limit=6";
//	portrait_small	50x75px
//	portrait_medium	100x150px
//	portrait_xlarge	150x225px
//	portrait_fantastic	168x252px
//	portrait_uncanny	300x450px
//	portrait_incredible	216x324px
	String varianteDeImagem= "/portrait_medium";
	String extension= ".png";
	String urlValida= base+varianteDeImagem+extension;
	String geradorMD5= timeStamp+apiKey+chavePrivada;
	String md5= "aa2280622171e5b4ace48242b11e867c";
	
	@Override
	public List<Conteudo> extratorDeConteudo(String json) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		ExtratorMarvel extM= new ExtratorMarvel();
		System.out.println(extM.base);
	}

}
