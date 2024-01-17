//import com.uludag.kuafor.entity.Token;
//import com.uludag.kuafor.repository.TokenRepository;
//import com.uludag.kuafor.service.JwtService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TokenService {
//
//    private final TokenRepository tokenRepository;
//    private final JwtService jwtService; // JwtService bağımlılığını enjekte et
//
//    public TokenService(TokenRepository tokenRepository, JwtService jwtService) {
//        this.tokenRepository = tokenRepository;
//        this.jwtService = jwtService;
//    }
//
//    public String generateAndSaveToken() {
//        // Token oluşturma işlemleri (JwtService veya başka bir yöntem ile)
//        String jwtToken = jwtService.generateToken();
//
//        // Token'ı veritabanına kaydetme
//        Token token = new Token();
//        token.setToken(jwtToken);
//        tokenRepository.save(token);
//
//        return jwtToken;
//    }
//}
