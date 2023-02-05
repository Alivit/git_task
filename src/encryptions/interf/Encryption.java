package encryptions.interf;

public interface Encryption {
    StringBuilder encoder(String str);
    StringBuilder decoder(String str);
}
