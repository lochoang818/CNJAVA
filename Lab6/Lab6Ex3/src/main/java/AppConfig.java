import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    @Qualifier("plainTextWriter")

    public  PlainTextWriter plainTextWriter(){
        return new PlainTextWriter();
    }

    @Bean
    @Qualifier("pdfTextWriter")
    public PdfTextWriter pdfTextWriter(){
        return new PdfTextWriter();
    }
    @Bean
    public TextEditor textWriter(){
        return new TextEditor();
    }

}
