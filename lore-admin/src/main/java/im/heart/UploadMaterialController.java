package im.heart;//package im.heart;
//
//import com.google.common.collect.Lists;
//import im.heart.core.CommonConst;
//import im.heart.core.utils.DateUtilsEx;
//import im.heart.core.utils.FileUtilsEx;
//import im.heart.core.utils.StringUtilsEx;
//import im.heart.core.web.AbstractController;
//import im.heart.core.web.ResponseError;
//import im.heart.core.web.enums.WebError;
//import im.heart.material.entity.MaterialPeriodical;
//import im.heart.material.entity.MaterialPeriodicalImg;
//import im.heart.material.service.MaterialPeriodicalImgService;
//import im.heart.material.service.MaterialPeriodicalService;
//import org.apache.commons.io.IOUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.rendering.PDFRenderer;
//import org.joda.time.DateTime;
//import org.jodconverter.DocumentConverter;
//import org.jodconverter.document.DefaultDocumentFormatRegistry;
//import org.jodconverter.document.DocumentFormat;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.annotation.Resource;
//import javax.imageio.ImageIO;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.util.Date;
//import java.util.List;
//
//@Controller
//public class UploadMaterialController extends AbstractController {
//    protected static final String apiVer = "/upload";
//    @Resource
//    private DocumentConverter documentConverter;
//    @Autowired
//    private MaterialPeriodicalService materialPeriodicalService;
//    protected static final String  FILE_PATH= CommonConst.STATIC_UPLOAD_ROOT;
//    @Autowired
//    private MaterialPeriodicalImgService materialPeriodicalImgService;
//    @Value("${prod.material.file.path}")
//    private String materialFilePath="";
//    @Value("${prod.upload.path.root}")
//    private String uploadFilePath="";
//    /**
//     *
//     * 文件上传
//     * @param file
//     * @param path
//     * @return
//     * @throws Exception
//     */
//    @Override
//    protected String uploadFile(MultipartFile file, String path) throws Exception {
//        return super.uploadFile(file,path,null);
//    }
//
//    @RequestMapping(apiVer + "/material")
//    public ModelAndView importBathMaterialImg(HttpServletRequest request,
//            @RequestParam(CommonConst.RequestResult.JSON_CALLBACK, required = false) String jsoncallback,
//            @RequestParam(value = "periodicalCode", required = false) String periodicalCode,
//            @RequestParam(value = "categoryId", required = false) BigInteger categoryId,
//            @RequestParam(value = "categoryCode", required = false) String categoryCode,
//            @RequestParam(value = "originPrice", required = false) BigDecimal originPrice,
//            @RequestParam(value = "finalPrice", required = false) BigDecimal finalPrice,
//            String filename,
//            HttpServletResponse response,ModelMap model) {
//        ResponseError responseError = new ResponseError(WebError.AUTH_CREDENTIALS_EXPIRED);
////        FrameUserVO user = SecurityUtilsHelper.getCurrentUser();
////        if (user == null) {
////            responseError = new ResponseError(WebError.INVALID_REQUEST);
////            super.fail(model, responseError);
////            return new ModelAndView(RESULT_PAGE);
////        }
//        List<MultipartFile> uploadFileList = super.getFileList(request);
//        if (uploadFileList != null && !uploadFileList.isEmpty()) {
//            for (MultipartFile file : uploadFileList) {
//                String realPath = uploadFilePath;
//                String path = File.separator+materialFilePath+File.separator + DateTime.now().toString("yyyyMMdd") + File.separator;
//                try {
//                    String realfileName = this.uploadFile(file, realPath + path);
//                    String url = StringUtilsEx.replace(path + realfileName, File.separator, "/");
//                    if (StringUtilsEx.isBlank(filename)) {
//                        filename = file.getOriginalFilename();
//                    }
//                    ////获取文件后缀
//                    String suffixes = StringUtils.substringAfterLast(realfileName, ".");
//                    MaterialPeriodical periodical = new MaterialPeriodical();
//                    String realfilePath=realPath + path+realfileName;
//                    periodical.setRealFilePath(realfilePath);
//                    periodical.setFileHeader(suffixes);
//                    periodical.setPeriodicalType(MaterialPeriodical.PeriodicalType.sharing.code);
////                    periodical.setAuthor(user.getNickName());
////                    periodical.setUserId(user.getUserId());
//                    periodical.setCategoryId(categoryId);
//                    periodical.setCategoryCode(categoryCode);
////                    periodical.setCityId(cityId);
////                    periodical.setCityName(cityName);
//                    periodical.setPeriodicalName(filename);
//                    periodical.setPeriodicalCode(periodicalCode);
//                    periodical.setFinalPrice(finalPrice);
//                    periodical.setOriginPrice(originPrice);
//                    periodical.setDataSize(file.getSize());
//                    periodical.setStatus(CommonConst.FlowStatus.INITIAL);
//                    periodical.setImportLog(DateUtilsEx.timeToString(new Date()) + " ,上传成功！<br/>");
//                    String pathUrl="/"+FILE_PATH+"/"+url;
//                    periodical.setPathUrl(pathUrl);
//                    this.materialPeriodicalService.save(periodical);
//                    DocumentFormat documentFormat= DefaultDocumentFormatRegistry.getInstance().getFormatByExtension(suffixes);
//                    File targetFile=new File(realfilePath+".pdf");
//                    this.documentConverter.convert(file.getInputStream(),true).as(documentFormat).to(targetFile).as(DefaultDocumentFormatRegistry.PDF).execute();
//                    Integer pageNum=this.pdf2Image(targetFile, realPath + path, 100,10,periodical);
//                    super.success(model, "url", pathUrl);
//                } catch (Exception e) {
//                    logger.error(e.getStackTrace()[0].getMethodName(), e);
//                    super.fail(model, new ResponseError(WebError.REQUEST_EXCEPTION));
//                    return new ModelAndView(RESULT_PAGE);
//                }finally {
//
//                }
//                return new ModelAndView(VIEW_SUCCESS);
//            }
//            super.fail(model, responseError);
//            return new ModelAndView(RESULT_PAGE);
//        }
//        super.fail(model, responseError);
//        return new ModelAndView(RESULT_PAGE);
//    }
//    /***
//     * PDF文件转PNG图片
//     * @param pdfFile pdf文件
//     * @param dstImgFolder 图片存放的文件夹
//     * @param dpi dpi越大转换后越清晰，相对转换速度越慢
//     * @param flag 页数 为0则转换全部页数
//     * @return
//     */
//    @Async
//    public Integer pdf2Image(File pdfFile, String dstImgFolder, int dpi,int flag,MaterialPeriodical periodical) {
//        PDDocument pdDocument=null;
//        Integer pageNum=0;
//        try {
//            if ("".equals(dstImgFolder)) {
//                dstImgFolder = pdfFile.getParent() ;
//            }
//            pdDocument = PDDocument.load(pdfFile);
//            PDFRenderer renderer = new PDFRenderer(pdDocument);
//            int pages = pdDocument.getNumberOfPages();
//            pageNum=pages;
//            if(flag > 0&&flag<pages) {
//              pages = flag;
//            }
//            List<MaterialPeriodicalImg> entities=Lists.newArrayList();
//            BigInteger periodicalId= periodical.getId();
//            String periodicalCode=periodical.getPeriodicalCode();
//            String periodicalType=periodical.getPeriodicalType();
//            String cityId=periodical.getCityId();
//            String imgFilePathPrefix = dstImgFolder+File.separator+periodicalCode+File.separator+periodicalId+File.separator;
//            for (int i = 0; i < pages; i++) {
//                int page=i+1;
//                String fileNameKey=periodicalId+"_"+page+".png";
//                File dstFile = new File(imgFilePathPrefix+fileNameKey);
//                if (!dstFile.exists()) {
//                    dstFile.mkdirs();
//                }
//                BufferedImage image = renderer.renderImageWithDPI(i, dpi);
//                ImageIO.write(image, "png", dstFile);
//                MaterialPeriodicalImg materialPeriodicalImg=new MaterialPeriodicalImg();
//                materialPeriodicalImg.setCityId(cityId);
//                materialPeriodicalImg.setPageNum(page);
//                materialPeriodicalImg.setPeriodicalCode(periodicalCode);
//                materialPeriodicalImg.setPeriodicalType(periodicalType);
//                String url  = StringUtilsEx.replace(dstFile.getPath(), File.separator, "/");
//                url =StringUtilsEx.replace(url, StringUtilsEx.replace(uploadFilePath, File.separator, "/") , "");
//                String imgUrl="/"+FILE_PATH+"/"+url;
//                materialPeriodicalImg.setImgUrl(imgUrl);
//                materialPeriodicalImg.setPathUrl(dstFile.getPath());
//                materialPeriodicalImg.setPeriodicalId(periodicalId);
//                if(i==0){
//                    periodical.setCoverImgUrl(imgUrl);
//                }
//                entities.add(materialPeriodicalImg);
//            }
//            periodical.setPageNum(pageNum);
//            periodical.setImportLog(periodical.getImportLog()+DateUtilsEx.timeToString(new Date()) +" 图片生成成功！<br/>");
//            periodical.setStatus(CommonConst.FlowStatus.PROCESSED);
//            this.materialPeriodicalService.save(periodical);
//            this.materialPeriodicalImgService.saveAll(entities);
//        } catch (Exception e) {
//            logger.error(e.getStackTrace()[0].getMethodName(), e);
//        }finally {
//            IOUtils.closeQuietly(pdDocument);
//            //删除pdf 文件
//            FileUtilsEx.deleteQuietly(pdfFile);
//        }
//        return pageNum;
//    }
//}
