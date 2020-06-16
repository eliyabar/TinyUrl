import React, {FunctionComponent, useEffect, useState} from 'react';
import {Tabs, message} from 'antd';
import './Main.css'
import ConvertToTiny from './ConvertToTiny';
import TinyToOriginal from './TinyToOriginal';

const {TabPane} = Tabs;

interface OwnProps {
}

type Props = OwnProps;

export const Main: FunctionComponent<Props> = (props) => {
    const [error, setError] = useState('')

    useEffect(()=>{
        if(error.length){
            message.warn(error)
            setError('')
        }
    }, [error])

    return (
        <div className="card-container">
            <Tabs type="card">
                <TabPane className={"tab"} tab="Convert to TinyUrl" key="1">
                    <ConvertToTiny showError={setError}/>
                </TabPane>
                <TabPane className={"tab"} tab="Get Original URL" key="2">
                    <TinyToOriginal showError={setError}/>
                </TabPane>
            </Tabs>
        </div>
    );
};