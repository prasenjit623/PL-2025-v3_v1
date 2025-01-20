package view.backing;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.sql.SQLException;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;

import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.BlobDomain;

import org.apache.commons.io.IOUtils;
import org.apache.myfaces.trinidad.component.UIXGroup;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.UploadedFile;

import util.ADFUtils;

public class Attachments {
    private RichPanelCollection pc1;
    private RichToolbar t1;
    private RichTable t2;
    private RichCommandImageLink cil1;
    private RichSpacer s1;
    private RichCommandImageLink cil2;
    private RichSpacer s2;
    private RichSpacer s3;
    private RichCommandButton cb1;
    private RichCommandButton cb2;
    private UIXGroup g1;
    private RichToolbar t3;
    private RichSpacer s4;
    private RichCommandImageLink cil5;
    private RichSpacer s5;
    private RichCommandButton cb3;
    private RichSpacer s6;
    private RichCommandButton cb4;
    private RichTable t4;

    public void setPc1(RichPanelCollection pc1) {
        this.pc1 = pc1;
    }

    public RichPanelCollection getPc1() {
        return pc1;
    }

    public void setT1(RichToolbar t1) {
        this.t1 = t1;
    }

    public RichToolbar getT1() {
        return t1;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    private BlobDomain createBlobDomain(UploadedFile file) {
        InputStream in = null;
        BlobDomain blobDomain = null;
        OutputStream out = null;
        try {
            in = file.getInputStream();
            blobDomain = new BlobDomain();
            out = blobDomain.getBinaryOutputStream();
            IOUtils.copy(in, out);
            //            byte[] buffer = new byte[8192];
            //            int bytesRead = 0;
            //            while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
            //                out.write(buffer, 0, bytesRead);
            //            }
            //
            //
            //            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
        return blobDomain;
    }

    private DCBindingContainer getBindingsCont() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String UploadFileActionToDB(UploadedFile file) {
        UploadedFile myfile = file;
        if (myfile != null) {
            DCIteratorBinding imageIter =
                (DCIteratorBinding)getBindingsCont().get("FuncAttachment_VO1Iterator");
            ViewObject vo = imageIter.getViewObject();
            Row curRow = vo.getCurrentRow();
            String filename = myfile.getFilename();
            String ContentType = myfile.getContentType();

            try {

            
                curRow.setAttribute("FileName", filename);
                curRow.setAttribute("FileType", ContentType);
                curRow.setAttribute("Attachment", createBlobDomain(myfile));
            } catch (Exception ex) {
            }
        }
        return null;
    }

    public void OnFileUpload(ValueChangeEvent vce) {
        //        vce.getComponent().processUpdates(FacesContext.getCurrentInstance());
        
        if (vce.getNewValue() != null) {
            //List<UploadedFile> lf = (List<UploadedFile>)vce.getNewValue();
            //for (UploadedFile fileVal : lf) {
            //
            UploadFileActionToDB((UploadedFile)vce.getNewValue());
            //                    ADFUtils
            //UploadFileActionToDB((UploadedFile)lf);
            //            ADFUtils.findOperation("Commit").execute();
//            ADFUtils.invokeEL("#{bindings.Commit.execute}");
        }
        //        }
        //        ResetUtils.reset(vce.getComponent());
        // }
    }

    public void onFileDownload(FacesContext facesContext,
                               OutputStream outputStream) {
        // Add event code here...
        ViewObject vc =
            ADFUtils.findIterator("FuncAttachment_VO1Iterator").getViewObject();
        //        DCIteratorBinding iteratorbinding =
        //            (DCIteratorBinding)getBindingsCont().get("XxfndFuncAttachmentView1Iterator");
        //DCIteratorBinding iteratorbinding =
        //           bindings.findIteratorBinding("DocumentsVO1Iterator");
        BlobDomain blob =
            (BlobDomain)vc.getCurrentRow().getAttribute("Attachment");
        try {
            IOUtils.copy(blob.getInputStream(), outputStream);
            blob.closeInputStream();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCil1(RichCommandImageLink cil1) {
        this.cil1 = cil1;
    }

    public RichCommandImageLink getCil1() {
        return cil1;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public void setCil2(RichCommandImageLink cil2) {
        this.cil2 = cil2;
    }

    public RichCommandImageLink getCil2() {
        return cil2;
    }

    public void setS2(RichSpacer s2) {
        this.s2 = s2;
    }

    public RichSpacer getS2() {
        return s2;
    }

    public void setS3(RichSpacer s3) {
        this.s3 = s3;
    }

    public RichSpacer getS3() {
        return s3;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }

    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }

    public void setT3(RichToolbar t3) {
        this.t3 = t3;
    }

    public RichToolbar getT3() {
        return t3;
    }


    public void setS4(RichSpacer s4) {
        this.s4 = s4;
    }

    public RichSpacer getS4() {
        return s4;
    }

    public void setCil5(RichCommandImageLink cil5) {
        this.cil5 = cil5;
    }

    public RichCommandImageLink getCil5() {
        return cil5;
    }

    public void setS5(RichSpacer s5) {
        this.s5 = s5;
    }

    public RichSpacer getS5() {
        return s5;
    }

    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }

    public void setS6(RichSpacer s6) {
        this.s6 = s6;
    }

    public RichSpacer getS6() {
        return s6;
    }

    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
    }

    public void setT4(RichTable t4) {
        this.t4 = t4;
    }

    public RichTable getT4() {
        return t4;
    }

    public void onClickAddAttachments(ActionEvent actionEvent) {
        ADFUtils.findOperation("CreateInsert").execute();
        ViewObject vo =
            ADFUtils.findIterator("FuncAttachment_VO1Iterator").getViewObject();
        vo.getCurrentRow().setAttribute("FuncId",
                                        AdfFacesContext.getCurrentInstance().getPageFlowScope().get("funcid"));
        vo.getCurrentRow().setAttribute("FuncRefId",
                                        AdfFacesContext.getCurrentInstance().getPageFlowScope().get("funcrefid"));
        vo.getCurrentRow().setAttribute("FuncTableName", "Property");

    }

    public void makeCurrent(SelectionEvent selectionEvent) {
    }
}
