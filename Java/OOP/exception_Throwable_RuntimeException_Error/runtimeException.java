package exception_Throwable_RuntimeException_Error;

/**
 * Runtime Exception adalah jenis exception yang tidak wajib ditangkap menggunakan try-catch
 *
 * Kompiler java tidak akan protes meskipun kita tidak menggunakan try-catch ketika memanggil method yang menyebabkan
 * runtime Exception
 *
 * untuk membuat class Runtime exception kita, kita wajib meng extends class RuntimeException
 *
 * ada banya di java yang merupakan RuntimeException, seperti NullPointerException, IllegalArgumentException DLL
 *
 * PERLU DIPERHATIKAN:
 * Walaupun runtime exception ntidak wajib di try-catch, tappi adabaiknya kita tetap melakukan try-catch
 *
 * Karna jika terjadi runtime exception, yang ditakutkan adalah program kita akan berhenti
 */

public class runtimeException {
}
