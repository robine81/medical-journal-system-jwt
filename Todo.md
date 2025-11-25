1. Få basic CRUD att fungera först (30 min)
   ✓ Service-lager (PatientService med några metoder)
   ✓ Controller (PatientController med GET/POST)
   ✓ Testa att det fungerar utan säkerhet
2. Basic Auth med roller (45 min)
   ✓ AppUser entity (username, password, role)
   ✓ CustomUserDetailsService
   ✓ SecurityConfig med Basic Auth
   ✓ Skapa 2 testanvändare: ADMIN och USER
   ✓ Testa att roller fungerar
3. JWT Implementation (1 timme)
   ✓ JwtService (generate token, validate token)
   ✓ LoginReqDTO + AuthController med /login endpoint
   ✓ JwtFilter (intercept requests, validate token)
   ✓ Uppdatera SecurityConfig för JWT
   ✓ Testa login → få token → använda token
4. Visa roller i action (30 min)
   ✓ ADMIN kan se alla patienter
   ✓ USER kan bara se sin egen data
   ✓ createdBy sätts från JWT-token