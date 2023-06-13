
package BlockChain;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Date;
import java.security.NoSuchAlgorithmException;


public class Block {
    private String versao;
    private Date Timestamp;
    private String hash;
    private String hashAnterior;
    private Prontuario dados;
    
    public Block(String versao, Date timestamp, Prontuario dados ){ 
    //Os dados aqui sao os prontuarios
           this.versao = versao;
           this.Timestamp = timestamp;
           this.dados = dados;
           this.hash = calcularHash(); //função que calcula o hash    
    }
    
    public String calcularHash(){
        
        String dadosParaHash = ""+this.versao+this.Timestamp+this.hashAnterior+this.dados;

        MessageDigest digest; //Digest significa compilado, digerido
        String encoded = null;

        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(dadosParaHash.getBytes(StandardCharsets.UTF_8));
            encoded = Base64.getEncoder().encodeToString(hash);
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        this.hash = encoded;
        return encoded;
    
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public Date getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(Date Timestamp) {
        this.Timestamp = Timestamp;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHashAnterior() {
        return hashAnterior;
    }

    public void setHashAnterior(String hashAnterior) {
        this.hashAnterior = hashAnterior;
    }

    public Prontuario getDados() {//ALTERADO
        return dados;
    }

    public void setDados(Prontuario dados) {//ALTERADO
        this.dados = dados;
    }
}
