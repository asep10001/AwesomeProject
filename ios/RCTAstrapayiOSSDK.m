//
//  RCTAstrapayiOSSDK.m
//  AwesomeProject
//
//  Created by Asep on 06/12/23.
//

#import "RCTAstrapayiOSSDK.h"
#import "SatisMeter/SatisMeter.h"
#import "AstrapayIosSdkWrapper.swift"
#import <React/RCTLog.h>
#import <Foundation/Foundation.h>

@implementation RCTAstrapayiOSSDK

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(setUp:(NSString *)token){
  RCTLogInfo(@"Ok token nya dapet %@", token);
}
@end
