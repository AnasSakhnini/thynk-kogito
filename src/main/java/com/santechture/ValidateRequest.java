package com.santechture;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.util.List;
import java.util.Random;

@Data

public class ValidateRequest {
            
           
            @JsonProperty(value = "Header")
            protected ValidateRequest.Header header;
            
            @JsonProperty(value = "Claim")
            protected ValidateRequest.Claim claim;
            @Data
            public static class Claim {
                protected Integer id;
                
                @JsonProperty(value = "EpisodeID")
                protected String episodeID;
                @JsonProperty(value = "MemberID")
                protected String memberID;
                
                @JsonProperty(value = "PayerID")
                protected String payerID;
                
                @JsonProperty(value = "ProviderID")
                protected String providerID;
                
                @JsonProperty(value = "EmiratesIDNumber")
                protected String emiratesIDNumber;
                
                @JsonProperty(value = "Gross")
                protected Float gross;
                
                @JsonProperty(value = "PatientShare")
                protected Float patientShare;
                
                @JsonProperty(value = "Net")
                protected Float net;
                @JsonProperty(value = "DenialCode")
                protected String denialCode;
                
                @JsonProperty(value = "Encounter")
                protected ValidateRequest.Claim.Encounter encounter;
                 
                @JsonProperty(value = "Diagnosis")
                protected List<ValidateRequest.Claim.Diagnosis> diagnosis;
                 
                @JsonProperty(value = "Activity")
                protected List<ValidateRequest.Claim.Activity> activity;
                @JsonProperty(value = "Resubmission") 
                protected ValidateRequest.Claim.Resubmission resubmission;
                @JsonProperty(value = "Contract") 
                protected ValidateRequest.Claim.Contract contract;
                @JsonProperty(value = "Patient") 
                protected ValidateRequest.Claim.Patient patient;
                @JsonProperty(value = "XClaim") 
                protected List<ValidateRequest.Claim.XClaim> xClaim;
                public String getSubmissionId(){
                    if (this.episodeID != null && !this.episodeID.isBlank()) {
                        return this.episodeID;
                    }else {
                        Random random = new Random();
                        return Integer.toString(Math.abs(random.nextInt(Integer.MAX_VALUE) +1));
                    }
                }
                @Data
                public static class Activity {
                    
                    @JsonProperty(value = "ID")
                    protected String id;
                    protected Integer idCaller;
                    
                    @JsonProperty(value = "Start")
                    protected String start;
                    
                    @JsonProperty(value = "Type")
                    protected Integer type;
                    
                    @JsonProperty(value = "Code")
                    protected String code;
                    
                    @JsonProperty(value = "Quantity")
                    protected Float quantity;
                    
                    @JsonProperty(value = "Net")
                    protected Float net;
                    
                    @JsonProperty(value = "Clinician")
                    protected String clinician;
                    @JsonProperty(value = "orderingClinician")
                    protected String orderingClinician;
                    @JsonProperty(value = "PriorAuthorizationID")
                    protected String priorAuthorizationID;
                    
                    @JsonProperty(value = "List")
                    protected Float list;
                    
                    @JsonProperty(value = "Gross")
                    protected Float gross;
                    
                    @JsonProperty(value = "PatientShare")
                    protected Float patientShare;
                    @JsonProperty(value = "PaymentAmount")
                    protected Float paymentAmount;
                    @JsonProperty(value = "DenialCode")
                    protected String denialCode;
                    
                    @JsonProperty(value = "VAT")
                    protected Float vat;
                    
                    @JsonProperty(value = "VATPercent")
                    protected Float vatPercent;
                    @JsonProperty(value = "Observation") 
                    protected List<ValidateRequest.Claim.Activity.Observation> observation;
                    @Data
                    public static class Observation {
                        
                        @JsonProperty(value = "Type")
                        protected String type;
                        
                        @JsonProperty(value = "Code")
                        protected String code;
                        @JsonProperty(value = "Value")
                        protected String value;
                        @JsonProperty(value = "ValueType")
                        protected String valueType;
                    }
                }
               @Data
                public static class Contract {
                    @JsonProperty(value = "PackageName")
                    protected String packageName;
                    @JsonProperty(value = "Network")
                    protected String network;
                    @JsonProperty(value = "SubNetworkName")
                    protected String subNetworkName;
                    @JsonProperty(value = "Policy")
                    protected String policy;
                }
                @Data
                public static class Diagnosis {
                    
                    @JsonProperty(value = "Type")
                    protected String type;
                    
                    @JsonProperty(value = "Code")
                    protected String code;
                    @JsonProperty(value = "DxInfo") 
                    protected List<ValidateRequest.Claim.Diagnosis.DxInfo> dxInfo;
                    @Data
                    public static class DxInfo {
                        protected String type;
                        protected String code;
                    }
                }
                @Data
                public static class Encounter {
                    
                    @JsonProperty(value = "FacilityID")
                    protected String facilityID;
                    
                    @JsonProperty(value = "Type")
                    protected Integer type;
                    
                    @JsonProperty(value = "PatientID")
                    protected String patientID;
                    
                    @Pattern(regexp = "(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4} (0[1-9]|1[0-9]|2[0-4]):([0-5][0-9])", message = "Invalid date and time format")
                    @JsonProperty(value = "Start")
                    protected String start;
                    @JsonProperty(value = "End")
                    protected String end;
                    
                    @JsonProperty(value = "StartType")
                    protected Integer startType;
                    @JsonProperty(value = "EndType")
                    protected Integer endType;
                    @JsonProperty(value = "TransferSource")
                    protected String transferSource;
                    @JsonProperty(value = "TransferDestination")
                    protected String transferDestination;
                    @JsonProperty(value = "NewPatient")
                    protected Integer newPatient;
                    protected String orderingClinician;
                    
                    @JsonProperty(value = "Authorisation")
                    protected ValidateRequest.Claim.Encounter.Authorisation authorisation;
                    protected Float birthWeight;
                    @Data
                    public static class Authorisation {
                        
                        @JsonProperty(value = "Start")
                        protected String start;
                        
                        @JsonProperty(value = "End")
                        protected String end;
                        @JsonProperty(value = "Verbal")
                        protected boolean verbal;
                    }
                }
                @Data
                public static class Patient {
                    
                    @JsonProperty(value = "GENDER_ID")
                    protected String genderId;
                    @JsonProperty(value = "EMIRATES_ID")
                    protected String emiratesId;
                    @JsonProperty(value = "PASSPORT_ID")
                    protected String passportId;
                    
                    @JsonProperty(value = "DATE_OF_BIRTH")
                    protected String dateOfBirth;
                    @JsonProperty(value = "NATIONALITY")
                    protected String nationality;
                    @JsonProperty(value = "MARTIAL_STATUS")
                    protected String martialStatus;
                    
                    @JsonProperty(value = "EMIRATE_TYPES")
                    protected Integer emirateTypes;
                   
                    
                    @JsonProperty(value = "PatientInsurance")
                    protected ValidateRequest.Claim.Patient.PatientInsurance patientInsurance;

                    @Data
                    public static class PatientInsurance {
                        
                        @JsonProperty(value = "MemberID")
                        protected String memberID;
                        
                        @JsonProperty(value = "ReceiverID")
                        protected String receiverID;
                        @JsonProperty(value = "PACKAGE_NAME")
                        protected String packageName;
                        @JsonProperty(value = "NetworkName")
                        protected String networkName;
                        @JsonProperty(value = "PlanName")
                        protected String planName;
                        
                        @JsonProperty(value = "START_DATE")
                        protected String startDate;
                        
                        @JsonProperty(value = "END_DATE")
                        protected String endDate;
                    }
                }
                @Data
                public static class Resubmission {
                    
                    @JsonProperty(value = "Type")
                    protected String type;
                    
                    @JsonProperty(value = "Comment")
                    protected String comment;
                    @JsonProperty(value = "Attachment")
                    protected byte[] attachment;
                }
                @Data
                public static class XClaim {
                    protected Integer id;
                    
                    @JsonProperty(value = "EpisodeID")
                    protected Integer episodeId;
                    @JsonProperty(value = "MemberID")
                    protected String memberID;
                    
                    @JsonProperty(value = "ReceiverID")
                    protected String receiverID;
                    
                    @JsonProperty(value = "PayerID")
                    protected String payerID;
                    
                    @JsonProperty(value = "ProviderID")
                    protected String providerID;
                    
                    @JsonProperty(value = "EmiratesIDNumber")
                    protected String emiratesIDNumber;
                    
                    @JsonProperty(value = "Gross")
                    protected Float gross;
                    
                    @JsonProperty(value = "PatientShare")
                    protected Float patientShare;
                    
                    @JsonProperty(value = "Net")
                    protected Float net;
                    @JsonProperty(value = "DenialCode")
                    protected String denialCode;
                    @JsonProperty(value = "XEncounter") 
                    protected ValidateRequest.Claim.XClaim.XEncounter xEncounter;
                    @JsonProperty(value = "XDiagnosis")  
                    protected List<ValidateRequest.Claim.XClaim.XDiagnosis> xDiagnosis;
                    @JsonProperty(value = "XActivity")  
                    protected List<ValidateRequest.Claim.XClaim.XActivity> xActivity;
                    @JsonProperty(value = "XResubmission") 
                    protected ValidateRequest.Claim.XClaim.XResubmission  xResubmission;
                    @JsonProperty(value = "XContract") 
                    protected ValidateRequest.Claim.XClaim.XContract xContract;
                    @Data
                    public static class XActivity {
                        @JsonProperty(value = "ID")
                        protected String id;
                        protected Integer idCaller;
                        @JsonProperty(value = "Start")
                        protected String start;
                        @JsonProperty(value = "Type")
                        protected Integer type;
                        @JsonProperty(value = "Code")
                        protected String code;
                        @JsonProperty(value = "Quantity")
                        protected Float quantity;
                        @JsonProperty(value = "Net")
                        protected Float net;
                        @JsonProperty(value = "ProviderNet")
                        protected Float providerNet;
                        @JsonProperty(value = "Clinician")
                        protected String clinician;
                        protected String orderingClinician;
                        @JsonProperty(value = "PriorAuthorizationID")
                        protected String priorAuthorizationID;
                        @JsonProperty(value = "List")
                        protected Float list;
                        @JsonProperty(value = "Gross")
                        protected Float gross;
                        @JsonProperty(value = "PatientShare")
                        protected Float patientShare;
                        @JsonProperty(value = "PaymentAmount")
                        protected Float paymentAmount;
                        @JsonProperty(value = "DenialCode")
                        protected String denialCode;
                        @JsonProperty(value = "Copayment")
                        protected Float copayment;
                        protected Float deductible;
                        @JsonProperty(value = "ManualPrices")
                        protected Boolean manualPrices;
                        protected Integer providerType;
                        protected String providerCode;
                        protected Float providerPatientShare;
                        @JsonProperty(value = "XObservation")
                        protected List<ValidateRequest.Claim.XClaim.XActivity.XObservation> xObservation;
                        public Boolean isManualPrices() {
                            return manualPrices;
                        }
                        @Data
                        public static class XObservation {
                            protected Integer idCaller;
                            @JsonProperty(value = "Type")
                            protected String type;
                            @JsonProperty(value = "Code")
                            protected String code;
                            @JsonProperty(value = "Value")
                            protected String value;
                            @JsonProperty(value = "ValueType")
                            protected String valueType;
                        }
                    }
                   @Data
                    public static class XContract {
                        @JsonProperty(value = "PackageName")
                        protected String packageName;
                        @JsonProperty(value = "Network")
                        protected String network;
                        @JsonProperty(value = "SubNetworkName")
                        protected String subNetworkName;
                        @JsonProperty(value = "Policy")
                        protected String policy;
                    }
                    @Data
                    public static class XDiagnosis {
                        
                        @JsonProperty(value = "Type")
                        protected String type;
                        
                        @JsonProperty(value = "Code")
                        protected String code;
                        @JsonProperty(value = "XDxInfo") 
                        protected List<ValidateRequest.Claim.XClaim.XDiagnosis.XDxInfo> xDxInfo;
                        @Data
                        public static class XDxInfo {
                            @JsonProperty(value = "type")
                            protected String type;
                            @JsonProperty(value = "code")
                            protected String code;
                        }
                    }
                    @Data
                    public static class XEncounter {
                        
                        @JsonProperty(value = "FacilityID")
                        protected String facilityID;
                        
                        @JsonProperty(value = "Type")
                        protected Integer type;
                        
                        @JsonProperty(value = "PatientID")
                        protected String patientID;
                        
                        @JsonProperty(value = "Start")
                        protected String start;
                        @JsonProperty(value = "End")
                        protected String end;
                        
                        @JsonProperty(value = "StartType")
                        protected Integer startType;
                        @JsonProperty(value = "EndType")
                        protected Integer endType;
                        @JsonProperty(value = "TransferSource")
                        protected String transferSource;
                        @JsonProperty(value = "TransferDestination")
                        protected String transferDestination;
                        @JsonProperty(value = "NewPatient")
                        protected Integer newPatient;
                        protected String orderingClinician;
                        @JsonProperty(value = "XAuthorisation") 
                        protected ValidateRequest.Claim.XClaim.XEncounter.XAuthorisation xAuthorisation;
                        @Data
                        public static class XAuthorisation {
                            
                            @JsonProperty(value = "Start")
                            protected String start;
                            
                            @JsonProperty(value = "End")
                            protected String end;
                            @JsonProperty(value = "Verbal")
                            protected boolean verbal;
                        }
                    }
                    @Data
                    public static class XResubmission {
                        
                        @JsonProperty(value = "Type")
                        protected String type;
                        
                        @JsonProperty(value = "Comment")
                        protected String comment;
                        @JsonProperty(value = "Attachment")
                        protected byte[] attachment;
                    }
                }
            }
            @Data
            public static class Header {
                
                @JsonProperty(value = "ReceiverID")
                protected String receiverID;
            }
}
