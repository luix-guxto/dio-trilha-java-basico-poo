package iphone;

public record InformacoesAparelho(String modelo, String cor, String imei, String numeroSerie, String versaoIOS,
                                  String versaoHardware, String versaoSoftware, String versaoFirmware,
                                  String versaoModem, String versaoBaseband, String versaoBootloader,
                                  String versaoKernel, String versaoBuild, String versaoCompilacao,
                                  String versaoCompilador, String versaoLinguagem, String versaoSistema,
                                  String versaoPlataforma, String versaoSDK, String versaoAPI) {

    @Override
    public String toString() {
        return "InformacoesAparelho{" +
                " modelo='" + modelo + "',\n" +
                " cor='" + cor + "',\n" +
                " imei='" + imei + "',\n" +
                " numeroSerie='" + numeroSerie + "',\n" +
                " versaoIOS='" + versaoIOS + "',\n" +
                " versaoHardware='" + versaoHardware + "',\n" +
                " versaoSoftware='" + versaoSoftware + "',\n" +
                " versaoFirmware='" + versaoFirmware + "',\n" +
                " versaoModem='" + versaoModem + "',\n" +
                " versaoBaseband='" + versaoBaseband + "',\n" +
                " versaoBootloader='" + versaoBootloader + "',\n" +
                " versaoKernel='" + versaoKernel + "',\n" +
                " versaoBuild='" + versaoBuild + "',\n" +
                " versaoCompilacao='" + versaoCompilacao + "',\n" +
                " versaoCompilador='" + versaoCompilador + "',\n" +
                " versaoLinguagem='" + versaoLinguagem + "',\n" +
                " versaoSistema='" + versaoSistema + "',\n" +
                " versaoPlataforma='" + versaoPlataforma + "',\n" +
                " versaoSDK='" + versaoSDK + "',\n" +
                " versaoAPI='" + versaoAPI + "'\n" +
                '}';
    }

}
