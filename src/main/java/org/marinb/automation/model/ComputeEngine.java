package org.marinb.automation.model;

import org.marinb.automation.pages.CalculatorFormPage;
import org.openqa.selenium.WebDriver;

public class ComputeEngine extends AbstractProduct{
    private int instancesNumber;
    private String operatingSystem;
    private String provisioningModel;
    private String machineFamily;
    private String series;
    private String machineType;
    private boolean GPU;
    private String gpuType;
    private int GPUsNumber;
    private int localSSD;
    private String location;
    private int usageTime;

    public ComputeEngine(){
        super("Compute Engine", null);
    }

    @Override
    public CalculatorFormPage fillForm( CalculatorFormPage calculatorFormPage) {
        return calculatorFormPage
                .switchToFormIframe()
                .fillNumberOfInstances(instancesNumber)
                .selectOperatingSystem(operatingSystem)
                .selectProvisioningModel(provisioningModel)
                .selectMachineFamily(machineFamily)
                .selectSeries(series)
                .selectMachineType(machineType)
                .clickAddGPUsCheckbox().selectGPUType(gpuType)
                .selectNumberOfGPUs(GPUsNumber)
                .selectLocalSSD(localSSD)
                .selectLocation(location)
                .selectUsage(usageTime)
                .clickAddToEstimateButton();
    }

    public static class Builder{
        private ComputeEngine newComputeEngine = new ComputeEngine();
        public Builder setInstancesNumber(int instancesNumber){
            newComputeEngine.instancesNumber = instancesNumber;
            return this;
        }
        public Builder setOperatingSystem(String operatingSystem){
            newComputeEngine.operatingSystem = operatingSystem;
            return this;
        }
        public Builder setProvisioningModel(String provisioningModel){
            newComputeEngine.provisioningModel = provisioningModel;
            return this;
        }
        public Builder setMachineFamily(String machineFamily){
            newComputeEngine.machineFamily = machineFamily;
            return this;
        }
        public Builder setSeries(String series){
            newComputeEngine.series = series;
            return this;
        }
        public Builder setMachineType(String machineType){
            newComputeEngine.machineType = machineType;
            return this;
        }
        public Builder setGPU(boolean GPU){
            newComputeEngine.GPU = GPU;
            return this;
        }
        public Builder setGpuType(String gpuType){
            newComputeEngine.gpuType = gpuType;
            return this;
        }
        public Builder setGPUsNumber(int GPUsNumber){
            newComputeEngine.GPUsNumber = GPUsNumber;
            return this;
        }
        public Builder setLocalSSD(int localSSD){
            newComputeEngine.localSSD = localSSD;
            return this;
        }
        public Builder setLocation(String location){
            newComputeEngine.location = location;
            return this;
        }
        public Builder setUsageTime(int timeUsage){
            newComputeEngine.usageTime = timeUsage;
            return this;
        }
        public ComputeEngine build(){
            return newComputeEngine;
        }

    }




}
